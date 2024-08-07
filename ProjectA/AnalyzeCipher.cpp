// -*- C++ -*-
// AnalyzeCipher.cpp

#include "AnalyzeCipher.h"

#include <typeinfo>

AnalyzeCipher::AnalyzeCipher(void)
{

}

AnalyzeCipher::~AnalyzeCipher(void)
{


}


void AnalyzeCipher::coIndex(std::array<float,26> alpha, int letter)
{
    if(letter == 0){

        std::cout << "Letter Error" << std::endl;

    }else{

        float newCalc;
        float tempCalc;

        float count = letter * (letter - 1);

        // calulate all alpha
        for(int i = 0; i < 26; i++)
        {
            float tempFreq = float(alpha[i] * (alpha[i] - 1));
            tempCalc = tempCalc + tempFreq;
        }

        newCalc = tempCalc;

        CI = (newCalc / count);
    }
}


float AnalyzeCipher::getIndexOfCoincidence(){
    //returns -1 coIndex has not been run
    return CI;
}