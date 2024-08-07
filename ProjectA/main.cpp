//main.cpp

#include <string>
#include <sstream>
#include <iostream>
#include <cstdio>
#include <fstream>
#include "Decrypter.h"


int main (){

    std::cout << std::endl << "Classical Cryptography Autosolver" << std::endl;
    std::cout << "Created By:" << std::endl;
    std::cout << "Salvatore Giambrone" << std::endl;
    std::cout << "Ella LeBeau" << std::endl;
    std::cout << "Steven Lin" << std::endl;

    while(true){

        int response = 0;
        std::string filename = " ";

        std::cout << std::endl << "What would you like to do?" << std::endl;
        std::cout << "1 - Decypher A Message" << std::endl;
        std::cout << "2 - Quit" << std::endl;
        
        std::cout << std::endl << "Enter: ";
        std::cin >> response;

        while(response != 1 && response != 2){

            std::cout << std::endl << "**INVALID RESPONSE**" << std::endl;

            std::cout << std::endl << "Enter: ";
            std::cin >> response;

            if(std::cin.fail()){
                std::cin.clear();
                std::cin.ignore(100 , '\n');
            }

            
        }

        if(response == 2){
            break;
        }

        int result = 0;

        std::cout << std::endl << "What File Do You Want To Decrypt?" << std::endl;
        std::cout << "Ex. type \"message\" for a file named \"message.txt\"" << std::endl;

        std::cout << std::endl << "Enter: ";
        std::cin >> filename;

        std::cout << std::endl << "File:" << filename << ".txt Selected" << std::endl;

        Decrypter deCypt;
        deCypt.setFile(filename+".txt");
        result = deCypt.run();

        if(result == 1){
            std::cout << "Decryption Succeeded" << std::endl;
        }
        else{
            std::cout << "Decryption Failed" << std::endl;
        }

    }


    return 0;

}
