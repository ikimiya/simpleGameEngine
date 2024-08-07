//caesarD.cpp

#include <string>
#include <iostream>
#include <fstream>
#include "Words.h"
#include "CaesarD.h"

using namespace std;

CaesarD::CaesarD()
{
	string file;
}

CaesarD::~CaesarD()
{

}

void CaesarD::setFile(string fileName)
{
	file = fileName;
}

string CaesarD::shift(string alphabet)
{
        char firstLetter = alphabet[0];
        for(int i=0; i<26; i++)
        {
                alphabet[i] = alphabet[i+1];
        }
        alphabet[25] = firstLetter;
        return alphabet;
}

string CaesarD::decode(string token, string key)
{
        string alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        string tokenShift;

        for(int i=0; i < token.length(); i++)
        {
                int position = key.find(token[i]);
                tokenShift = tokenShift + alphabet[position];
        }

        return tokenShift;
}

int CaesarD::solve(string message)
{
        string alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        string shiftAlphabet = alphabet;
        string shiftMessage;
        string token;
        string response = "n";
        bool found = false;
	cout << "DECRYPTING MESSAGE: " << message << endl;

        for(int i=1; i<26; i++)
        {
                shiftAlphabet = shift(shiftAlphabet);
                int count = 0;
                int position = 0;
                string temp = message;
                Words* w = new Words();

                while(count < temp.length())
                {
                        position = temp.find(" ");
                        token = temp.substr(0, position);
                        temp = temp.substr(position + 1);
                        count = position;

                        string shiftFrag = decode(token, shiftAlphabet);
                        if(w->checkWords(shiftFrag))
                        {
                                found = true;
                        }

                        shiftMessage = shiftMessage + " " + shiftFrag;

                }

                if(found == true)
                {
                        cout << "YOUR MESSAGE IS: " << shiftMessage << endl;
			cout << endl << "Does this plaintext look correct (y/n):	";
			cin >> response;
			cout << endl;

                        if (response == "y"){
                                cout << endl << "Ending Caesar Decryption" << endl << endl;
                                return 1;
                        }
                        else if(response == "n"){
                                shiftMessage = "";
				break;
                        }
                        else{
                                cout << endl << "**INVALID RESPONSE**" << endl;

                                if(cin.fail()){
                                        cin.clear();
                                        cin.ignore(100 , '\n');
                                }
                        }
                }

                else
                {
                        shiftMessage = "";
                }


        }

        std::cout << std::endl << "Ending Caesar Decryption" << std::endl << std::endl;
        return 0;

}

int CaesarD::fileR()
{
	ifstream inFile;
	string currentLine;
	inFile.open(file);
        std::cout << std::endl << "Starting Caesar Decryption" << std::endl << std::endl;
	while(getline(inFile, currentLine))
	{
		return solve(currentLine + " ");
	}

}
