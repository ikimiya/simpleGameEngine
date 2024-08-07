//CaesarT.cpp

#include <cstdio>
#include <iostream>
#include "CaesarT.h"


/**
 * @brief Construct a new CaesarT::CaesarT object
 */
CaesarT::CaesarT(){ 

    standardIndex = .00667;

}


/**
 * @brief Destroy the CaesarT::CaesarT object
 */
CaesarT::~CaesarT(void){ }


/**
 * @brief set the file to be tested and run it though Frequency.cpp
 * 
 * @param fileName 
 */
void CaesarT::setFile(std::string fileName){

    cipherfreq.readFile(fileName);
    cipherfreq.readAndCalculate();

}


/**
 * @brief Runs the testing process of caesar cipher
 * 
 * @return int 
 *         1 - A caesar cipher
 *         0 - Is not 
 */
int CaesarT::run(void){

    float cipherIndex = cipherfreq.aCipher.CI;
    std::cout << "Cipher Index: " << cipherIndex << std::endl;

    if (cipherIndex >= standardIndex - .07 &&
        cipherIndex <= standardIndex + .07 ){

        std::cout << "Caesar - Positive" << std::endl;
        return 1;
    }

    std::cout << "Caesar - Negative" << std::endl;



    return 0;
}