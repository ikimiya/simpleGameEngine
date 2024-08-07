// -*- C++ -*-
// FileRead.h 

#ifndef _FILEREAD_H_
#define _FILEREAD_H_

#include <string>
#include <sstream>
#include <iostream>
#include <fstream>

class FileRead{


    public:

        FileRead(void);

        ~FileRead(void);

        void readFile(std::string text);

        void outputFile(void);

        int cipherLength(void);



        std::string cipherNoSpace();
        
        
        std::string plainText;
        std::string cipherText;


    private: 

};






#endif