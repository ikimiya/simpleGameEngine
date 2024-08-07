// CaesarT.h 

#ifndef _CAESART_H_
#define _CAESART_H_

#include <string>
#include <sstream>
#include <iostream>
#include <cstdio>
#include <fstream>
#include "Frequency.h"

class CaesarT{

    public:

        CaesarT();

        ~CaesarT(void);

        void setFile(std::string fileName);

        int run(void);

        Frequency cipherfreq;

        float standardIndex;


    private: 

};

#endif