//words.cpp

#include <string>
#include <iostream>
#include <fstream>
#include <cstring>
#include "Words.h"

using namespace std;

Words::Words()
{

}

Words::~Words()
{

}

bool Words::checkWords(string token)
{
        ifstream inFile;
        string currentLine;
        string newToken;

        for(int i=0; i<token.length(); i++)
        {
                //putchar(tolower(token[i]));
                newToken = newToken + char(tolower(token[i]));
                //cout << newToken << endl;
        }
        inFile.open("dict.txt");
        //cout << token << endl;

        while(getline(inFile, currentLine))
        {
                //cout << currentLine << endl;

                if(currentLine == newToken)
                {
                        //cout << "MATCH FOUND" << endl;
                        return true;
                }
        }

        //cout << "NO MATCH FOUND" << endl;
        return false;
}
