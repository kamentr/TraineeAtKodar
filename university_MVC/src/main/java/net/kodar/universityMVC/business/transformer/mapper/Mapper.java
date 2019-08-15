package net.kodar.universityMVC.business.transformer.mapper;

import org.springframework.web.servlet.ModelAndView;

public interface Mapper {
    void map(ModelAndView modelAndView, Object...args);
}
