package com.ssg.product_manageapp.controller;


import com.ssg.product_manageapp.dto.PageRequestDTO;
import com.ssg.product_manageapp.dto.ProductDTO;
import com.ssg.product_manageapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){
        log.info("product list!!!!!!!!!!!!!!!!");
        if(bindingResult.hasErrors()){
            pageRequestDTO = pageRequestDTO.builder().build();
        }
        log.info(model);
        model.addAttribute("responseDTO", productService.getList(pageRequestDTO));
    }

    @GetMapping("/register")

    public void register() {
        log.info("register!!");
    }

    @PostMapping("/register")
    public String registerPost(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        //@Valid 어노테이션을 사용하여 ProductDTO 객체를 유효성 검사합
        //BindingResult 객체를 사용하여 유효성 검사 결과를 가져옵니다.
        log.info(productDTO);
        log.info("register post");
        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            log.info("has errors");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            //유효성 검사 결과에 오류가 있으면 이를 로깅하고 "redirect:/product/register"로 리디렉션하면서 오류 메시지를 Flash attribute로 추가합니다.
            return "redirect:/product/register";
        }
        log.info(productDTO);
        productService.register(productDTO);

        return "redirect:/product/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(long id, Model model){
        ProductDTO productDTO = productService.getOne(id);
        model.addAttribute("dto",productDTO);
    }

    @PostMapping("/remove")
    public String remove(long id) {
        log.info(id);
        productService.remove(id);
        return "redirect:/product/list";
    }

    @PostMapping("/modify")
    public String modify(@Valid ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info(productDTO);
        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            log.info("ERROR");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            redirectAttributes.addAttribute("id", productDTO.getId());
            return "redirect:/product/modify";
        }
        productService.modify(productDTO);
        return "redirect:/product/list";
    }

}
