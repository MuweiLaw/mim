package com.murray.mim.commons.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(
        originPatterns = {"*"},
        allowCredentials = "true",
        allowedHeaders = {"*"},
        methods = {}
)
public interface BaseController {
}
