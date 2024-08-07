// -*- C++ -*-
// AnalyzeCipher.h 

#ifndef _ANALYZECIPHER_H_
#define _ANALYZECIPHER_H_

#include <string>
#include <sstream>
#include <iostream>
#include <fstream>
#include <array>

class AnalyzeCipher{


    public:

        AnalyzeCipher(void);

        ~AnalyzeCipher(void);

        // requires frequency alphabet and number of letters
        void coIndex(std::array<float,26> testArray, int letter);

        float getIndexOfCoincidence();

        float CI = -1;

        std::string alphabet = "abcdefghijklmnopqrstuvwxyz";

    private: 

};






#endif