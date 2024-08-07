// -*- C++ -*-
// FileRead.cpp


#include "FileRead.h"
#include <cctype>
#include <algorithm>

FileRead::FileRead(void)
{

}

FileRead::~FileRead(void)
{

}

void FileRead::readFile(std::string inputText)
{
    std::ifstream inFile;
    std::string currentLine;

    inFile.open(inputText);  // must include .txt

    int i = 0;

    if(inFile.is_open() ){
        std::string tempString;

        while(inFile >> tempString){

            if(i == 0){
                cipherText = cipherText + tempString;
                i++;
            }else{
                cipherText = cipherText + " " + tempString;
            }
        }
    }
    inFile.close();

}

// testing to print the plaintext and cipher from current file
void FileRead::outputFile(void)
{
    std::cout << "Test1 " << "PlainText: " << plainText << std::endl;
    std::cout << "Test2 " << "CipherText:" << cipherText << "."<< std::endl;
}

int FileRead::cipherLength(void){

    // Counts all letters, skips blank space
    std::string newString = cipherText;
        newString.erase(std::remove_if(newString.begin(), newString.end(), ::ispunct),
        newString.end());
        newString.erase(std::remove_if(newString.begin(), newString.end(), ::isspace),
        newString.end());
        
    return newString.length();
}

std::string FileRead::cipherNoSpace(void)
{
    std::string newString = cipherText;
        newString.erase(std::remove_if(newString.begin(), newString.end(), ::isspace),
        newString.end());

    return newString;
}

