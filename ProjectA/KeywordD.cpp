//KeywordD.cpp

#include <cstdio>
#include <array>
#include <iostream>
#include <string>
#include <sstream>
#include <fstream>
#include "KeywordD.h"


/**
 * @brief Construct a new KeywordD::KeywordD object
 */
KeywordD::KeywordD(){ 

    std::string file;

    standardFreqL = {'e','t','a','o','n','i','h','s','r','d','l','u','m','c','w','f','y','g','p','b','v','k','x','q','j','z'};

    //Included just in case I need them 
    //standardFreqN[] = {12.02, 9.10, 8.12, 7.68, 7.31, 6.95, 6.28, 6.02, 5.92, 4.32, 3.98, 2.88, 2.71, 2.61, 2.30, 2.11, 2.09, 2.03, 1.82, 1.49, 1.11, 0.69, 0.17, 0.11, 0.10, 0.07};

}


/**
 * @brief Destroy the KeywordD::KeywordD object
 */
KeywordD::~KeywordD(void){ }


/**
 * @brief set the file to be decrypted and run it though Frequency.cpp
 * 
 * @param fileName 
 */
void KeywordD::setFile(std::string fileName){

    file = fileName;

    cipher.readFile(fileName);
    cipher.readAndCalculate();

    cipherFreq = cipher.getFrequencyAlphabet();
}


/**
 * @brief Uses the sorted frequency analysis from Frequency.cpp to replace the cipher letters
 *        with their corresponding standard english frequency analysis letters
 */
void KeywordD::decrypt(void){

    std::ifstream cipherFile(file);

    std::cout << "\nPlaintext: ";

    char currentChar;
    int letter = 0;
    while(cipherFile.get(currentChar)){

        //replace highest cipher freq with standard freq
        for(int i=0 ; i<26 ; i++){
            
            if(currentChar == cipherFreq[i]){
                std::cout << standardFreqL[i];
                letter = 1;
                break;
            }
        }

        if(letter == 0){
            std::cout << currentChar;
        }

        letter = 0;
    }

}


/**
 * @brief Runs decryption untill user says correct cypher is found
 * 
 * @return int 
 *         1 - Stop, found plaintext
 *         0 - Not correct cipher method 
 */
int KeywordD::run(void){

    std::cout << std::endl << "Starting Keyword Mono Decryption" << std::endl << std::endl;

    std::string response = "n";

    //int cipherfreqN[26] = cipher.getFrequencyArray();

    decrypt();

    while(true){
        std::cout << std::endl << std::endl << "Does this plaintext look correct? (y/n):    ";
        std::cin >> response;
        std::cout << std::endl << "Ending Keyword Mono Decryption" << std::endl << std::endl;

        if (response == "y"){
            return 1;
        }
        else if(response == "n"){
            return 0;
        }
        else{
            std::cout << std::endl << "**INVALID RESPONSE**" << std::endl;

            if(std::cin.fail()){
                std::cin.clear();
                std::cin.ignore(100 , '\n');
            }
        }
    }
}