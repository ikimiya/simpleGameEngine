// KeywordD.h 

#ifndef _KEYWORDD_H_
#define _KEYWORDD_H_

#include <array>
#include <string>
#include <sstream>
#include <iostream>
#include <cstdio>
#include <fstream>
#include "Frequency.h"

class KeywordD{

    public:

        KeywordD();

        ~KeywordD(void);

        void setFile(std::string fileName);

        int run(void);

        void decrypt(void);

        Frequency cipher;

        std::string file;

        std::array<char,26> standardFreqL;

        std::array<char,26> cipherFreq;

        //char standardFreqN[];

    private: 

};

#endif