// AnagramT.h 

#ifndef _ANAGRAMT_H_
#define _ANAGRAMT_H_

#include <array>
#include <string>
#include <sstream>
#include <iostream>
#include <cstdio>
#include <fstream>
#include "Frequency.h"
#include <vector>

class AnagramT{

    public:

        AnagramT();

        ~AnagramT(void);

        void setFile(std::string fileName);

        int run(void);

        void calculate(void);

        void changeBlockOrder(void);

        void createChecker(std::string word);

        void organizeOrder(void);

        void setKeyword(std::string);

        std::string getDecipherText();

        void print(void);

        Frequency cipher;
        std::string textFile;

        // Word for key for tranposition
        std::string keyWord;

        std::vector<bool> checkCorrect;
        std::vector<int> keyOrder;

        std::string decipherText;
        std::string cipherText;


    

    private: 

};

#endif