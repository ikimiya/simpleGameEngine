//KeywordT.cpp

#include <cstdio>
#include <iostream>
#include "KeywordT.h"


/**
 * @brief Construct a new KeywordT::KeywordT object
 */
KeywordT::KeywordT(){ 

    standardIndex = .00667;

}


/**
 * @brief Destroy the KeywordT::KeywordT object
 */
KeywordT::~KeywordT(void){ }


/**
 * @brief set the file to be tested and run it though Frequency.cpp
 * 
 * @param fileName 
 */
void KeywordT::setFile(std::string fileName){

    cipherfreq.readFile(fileName);
    cipherfreq.readAndCalculate();

}


/**
 * @brief Runs the testing process of mono keyword cipher
 * 
 * @return int 
 *         1 - A mono keyword cipher
 *         0 - Is not 
 */
int KeywordT::run(void){

    float cipherIndex = cipherfreq.aCipher.CI;
    std::cout << "Cipher Index: " << cipherIndex << std::endl;

    if (cipherIndex >= standardIndex - .07 &&
        cipherIndex <= standardIndex + .07 ){

        std::cout << "Keyword Mono - Positive" << std::endl;
        return 1;
    }

    std::cout << "Keyword Mono - Negative" << std::endl;



    return 0;
}