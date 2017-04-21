package ru.bzhumataev.web;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bzhumataev.model.Note;
import ru.bzhumataev.service.NoteService;
import ru.bzhumataev.session.UserSession;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
@RequestMapping("/")
public class IndexController {

    @Resource
    private NoteService noteService;

    @RequestMapping(method = GET)
    public String indexPage(@RequestParam(value = "hide", defaultValue = "1") int page,
                            @RequestParam(value = "hideId", defaultValue = "0") long id,
                            Model model) {
        List<Note> notes = new ArrayList<>(noteService.findNotes());

        if (id != 0) {
            if (page != 1 &&
                    page == UserSession.getPages() &&
                    (UserSession.getPages() * UserSession.getCount()) - 9 == notes.size() &&
                    notes.get(notes.size() - 1).getId() == id) {
                page--;
                notes.remove(notes.size() - 1);
            }

            for (int i = 0; i < notes.size(); i++) {
                if (notes.get(i).getId() == id) {
                    notes.remove(i);
                    break;
                }
            }
            noteService.remove(id);
        }

        UserSession.setPages(notes, UserSession.getCount());

        if (notes.size() > UserSession.getCount()) {
            if (page * UserSession.getCount() > notes.size()) {
                notes = notes.subList((page - 1) * UserSession.getCount(), notes.size());
            } else {
                notes = notes.subList((page - 1) * UserSession.getCount(), page * UserSession.getCount());
            }
        }
        model.addAttribute("notes", notes);
        model.addAttribute("page", page);
        model.addAttribute("pages", UserSession.getPages());

        return "index";
    }

    @RequestMapping(value = "/add", method = POST)
    public String add(@RequestBody String note) {
        JSONObject jsonObject = new JSONObject(note);
        noteService.add(new Note(jsonObject.getString("title"), jsonObject.getString("text")));
        return "index";
    }
}