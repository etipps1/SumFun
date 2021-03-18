package com.example.sumfun.presenter;

/**
 * public interface MathLevel
 * public method  doMath() returns String
 * public method  getCountLoop() returns int
 * public method getCountCorrect() return int
 * purpose: interface which math level to use
 */

public interface MathLevel {
    String doMath();
    int getCountLoop();
    int getCountCorrect();
}
