package io.aka.test;

import io.aka.annotations.Controller;
import io.aka.annotations.http.Get

@Controller
class Index {

    @Get("/index")
    fun index(){
    }
}
