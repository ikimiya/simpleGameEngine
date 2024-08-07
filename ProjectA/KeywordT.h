// KeywordT.h 

#ifndef _KEYWORDT_H_
#define _KEYWORDT_H_

#include <string>
#include <sstream>
#include <iostream>
#include <cstdio>
#include <fstream>
#include "Frequency.h"

class KeywordT{

    public:

        KeywordT();

        ~KeywordT(void);

        void setFile(std::string fileName);

        int run(void);

        Frequency cipherfreq;

        float standardIndex;


    private: 

};

#endif