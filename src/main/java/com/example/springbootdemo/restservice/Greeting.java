package com.example.springbootdemo.restservice;

/*
 * Application uses the Jackson JSON library to automatically marshal instances of type Greeting into JSON.
 * Jackson is included by default by the web starter.
 */
public record Greeting(long id, String content) { }
