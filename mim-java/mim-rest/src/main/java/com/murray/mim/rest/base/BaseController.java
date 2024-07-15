package com.murray.mim.rest.base;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(
        originPatterns = {"*"},
        allowCredentials = "true",
        allowedHeaders = {"*"},
        methods = {}
)
public interface BaseController {
}
