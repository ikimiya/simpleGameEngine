// Decrypter.h 

#ifndef _DECRYPTER_H_
#define _DECRYPTER_H_


#include <string>
#include <sstream>
#include <iostream>
#include <cstdio>
#include <fstream>

#include "CaesarD.h"
#include "CaesarT.h"
#include "KeywordT.h"
#include "KeywordD.h"
#include "AnagramT.h"

class Decrypter{

    public:

        Decrypter();

        ~Decrypter(void);

        void setFile(std::string fileName);

        void test();

        int decypher(void);

        int run(void);

        CaesarT cT;
        CaesarD cD;

        KeywordT kT;
        KeywordD kD;

        AnagramT aT;

        int cypherUsed[3];


    private: 

};

#endif