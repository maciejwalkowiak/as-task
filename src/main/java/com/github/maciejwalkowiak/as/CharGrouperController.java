package com.github.maciejwalkowiak.as;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CharGrouperController {
    private final CharGrouper charGrouper;

    @Autowired
    CharGrouperController(CharGrouper charGrouper) {
        Assert.notNull(charGrouper);
        this.charGrouper = charGrouper;
    }

    @RequestMapping(value = "group", method = RequestMethod.GET, produces = "text/plain")
    public String group(@RequestParam String input) {
        return charGrouper.group(input);
    }
}
