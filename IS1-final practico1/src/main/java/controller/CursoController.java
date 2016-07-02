package controller;
/**
 * Created by rodrigo on 01/12/15.
 */
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.CursoService;
import domain.Alumno;
import domain.Curso;

@Controller
public class CursoController {

    @Autowired
    CursoService cursoService;

    @RequestMapping(value = "/add-curso", method = RequestMethod.GET)
    String addNewcurso(@RequestParam(required = false) Long id, ModelMap model) {
        Curso curso = id == null ? new Curso() : cursoService.get(id);
        model.addAttribute("curso", curso);
        return "add-curso";
    }

    @RequestMapping(value = "/curso", method = RequestMethod.POST)
    String savecurso(@ModelAttribute Curso curso, ModelMap model) {
        System.out.println("savving: " + curso.getId());
        cursoService.save(curso);
        return showcurso(curso.getId(), model);
    }

    @RequestMapping(value = "/search-curso", method = RequestMethod.GET)
    String searchNewalumnoIndex(String codigo, ModelMap model) {
        return "search-curso";
    }
    @RequestMapping(value = "/search-curso", method = RequestMethod.POST)
    String searchNewalumno(String codigoC,ModelMap model) {
            Curso curso=cursoService.buscarPorCodigo(codigoC);
            model.addAttribute("curso", curso);
        return "curso";
    }




    @RequestMapping(value = "/curso", method = RequestMethod.GET)
    String showcurso(@RequestParam(required = false) Long curso_id, ModelMap model) {
        if (curso_id != null) {

            Curso curso = cursoService.get(curso_id);
            model.addAttribute("curso", curso);
            return "curso";
        } else {
            Collection<Curso> people = cursoService.getAll();
            model.addAttribute("curso_list", people);
            return "cursos";
        }
    }

}