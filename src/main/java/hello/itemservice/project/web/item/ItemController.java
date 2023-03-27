package hello.itemservice.project.web.item;

import hello.itemservice.project.domain.item.Item;
import hello.itemservice.project.service.item.ItemSearchCond;
import hello.itemservice.project.service.item.ItemService;
import hello.itemservice.project.service.item.UpdateDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/items")
@Slf4j
public class ItemController {

    private final ItemService itemService;


    @GetMapping("/add")
    public String addForm(@ModelAttribute Item item) {
        return "/items/addForm";
    }

    @PostMapping("/add")
    public String save(@Validated @ModelAttribute Item item, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("error = {}",bindingResult);
            return "/items/addForm";
        }
        Item savedItem = itemService.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemService.findById(itemId).orElseThrow();
        model.addAttribute("item", item);
        return "/items/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String update(@PathVariable Long itemId, @Validated @ModelAttribute UpdateDAO updateDAO) {
        itemService.update(itemId, updateDAO);
        return "redirect:/items/{itemId}";
    }

    @GetMapping
    public String items(@ModelAttribute("cond") ItemSearchCond cond, Model model) {
        List<Item> items = itemService.findAll(cond);
        model.addAttribute("items", items);
        return "/items/items";
    }

    @GetMapping("{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemService.findById(itemId).orElseThrow();
        model.addAttribute("item", item);
        return "/items/item";
    }
}
