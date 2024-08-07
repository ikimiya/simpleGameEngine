// AnagramT.cpp

#include "AnagramT.h"

AnagramT::AnagramT()
{

}

AnagramT::~AnagramT()
{

}


void AnagramT::setFile(std::string fileName){

    textFile = fileName;
}


/*
    calculates matrix of blankvalues,size
    creates arrays, swap it to key, then read left to right for decryption
*/
void AnagramT::calculate()
{
    int k = 0;

    int plainLength = cipher.fRead.cipherLength();

    int column = keyWord.size();
    int row = plainLength / column + (plainLength % column != 0);

    int blankCell = plainLength % column;
    cipherText = cipher.fRead.cipherNoSpace();
    
    std::vector<int> blank;

    // Find amount of blank cells 
    for(int i = blankCell ; i < column; i++)
    {
        if(plainLength % column == 0)
        {
        }else{
            blank.push_back(keyOrder[i]);
        }
    }

    // Create dynamically 2d Arrays
    char ** blankMatrix = new char*[column];
    char ** swapArray = new char*[column];
    char ** finalArray = new char*[row];

    // initalize column with row or row with column
    for(int i = 0; i < column; i++){
        blankMatrix[i] = new char[row];
    }
    for(int i = 0; i < column; i++){
        swapArray[i] = new char[row];
    }
    for(int i = 0; i < row; i++){
        finalArray[i] = new char[column];
    }

    // break check variables
    bool isBlank = false;
    k = 0;

    // create matrix for blankMatrix 
    for(int i = 0; i < column; i++){
           for(int m = 0; m < blank.size(); m++)
               {
                if(i == blank[m]){
                    isBlank = true;
                }
            }
        for(int j = 0; j < row; j++)
        {
            if(isBlank){
                if(j == row - 1){
                    blankMatrix[i][j] = '$';
                }else{
                    blankMatrix[i][j] = cipherText[k];
                    k++;
                }
            }else{
                blankMatrix[i][j] = cipherText[k];
                k++;
            }
        }
        isBlank = false;
    }   // end break

    // Swap the array rows by key order
    for(int i = 0; i < column; i++)
        {
            int swap = keyOrder[i];
            for(int j = 0; j < row; j++)
            {
               swapArray[i][j] = blankMatrix[swap][j]; 
            }
    }   // end swap

    // Set empty matrix [row][column] from a [column][row] matrix
    for(int i = 0; i < row; i++)
    {
        for(int j = 0; j < column; j++){
            finalArray[i][j] = swapArray[j][i];
        }
    }   

    //  Loop through decrypt matrix and set string 
    for(int i = 0; i < row; i++)
    {
        for(int j = 0; j < column; j++){
            //std::cout << *(last + i * column + j);
            decipherText += finalArray[i][j];
        }
    }
    
    //std::cout << "plain length" << plainLength << std::endl;
    //std::cout << "blakce " << blankCell << std::endl;
    //std::cout <<  (plainLength % column)+ (plainLength % column != 0) << std::endl;

    decipherText.erase( plainLength ,decipherText.length());
    //std::cout << "Final Decrpyt Word:" << decipherText <<  std::endl;

    // Delete the array created
    for (int i = 0; i < column; i++) 
    {
        delete[] blankMatrix[i];
        delete[] swapArray[i];
    }                     

    for (int i = 0; i < row; i++) 
    {
        delete[] finalArray[i];
    }      

    delete[] blankMatrix;
    delete[] swapArray;
    delete[] finalArray;
}

/*
    changeBlockOrder
    find keyword char letter and get index from alphabet
*/
void AnagramT::changeBlockOrder(void)
{
    createChecker(keyWord);

    for(int i = 0 ; i < keyWord.size() ; i++)
    {
        keyOrder.push_back(cipher.alphabet.find_first_of(keyWord[i]));
    }
}

/*
    boolean checker with length of keyWord
*/
void AnagramT::createChecker(std::string key)
{
    for(int i = 0; i < key.size(); i++){
        checkCorrect.push_back(false);
    }
}

/*
    Organize order from alpha index to
    a to z order from max size
*/
void AnagramT::organizeOrder(void)
{
    bool keepGoing = true;
    bool wordLoop = true;

    int closeCounter = 0;

    int n = keyWord.size() - 1;
    int i = 0;
    int counter = 0;
    int maxNumber;
    int maxIndex;

    while(keepGoing){

        // Check if it has not been changed
        if(checkCorrect[i] == false){
            counter = 0;
            maxNumber = keyOrder[i];
            maxIndex = i;
            wordLoop = true;

            while(wordLoop)
            {
                // Check if it has not been change 
                if(checkCorrect[counter] == false)
                {
                    // Check if number is the largest
                    if(keyOrder[counter] >= maxNumber)
                    {
                        maxNumber = keyOrder[counter];
                        maxIndex = counter;
                    }
                }
                else
                {
                }

                counter++;

                // end loop at max number
                if(counter % keyWord.size() == 0)
                {
                    // set values and reduce N by one
                    checkCorrect[maxIndex] = true;
                    keyOrder[maxIndex] = n;
                    n--;
                    wordLoop = false;
                }
            }
        }
        else
        {
            // IF all key is True end loop
            closeCounter++;
            if(closeCounter == checkCorrect.size()){
                keepGoing = false;
            }
        }
        i = (i + 1) % keyWord.size();
    }
}


/*
    Set Keyword
*/
void AnagramT::setKeyword(std::string key)
{
    keyWord = key;
}

void AnagramT::print()
{
    for(int i = 0; i < keyOrder.size(); i++)
    {
        std::cout << "order: " << i << " :"  << keyOrder[i] << std::endl;
    }


    /*
    for(int i = 0; i < checkCorrect.size(); i++)
    {
        std::cout << "checkcorrect: : " << checkCorrect[i] << std::endl;
    }
    */

}

std::string AnagramT::getDecipherText()
{
    return decipherText;
}

int AnagramT::run()
{
    std::cout << std::endl << "Starting Anagram Decryption" << std::endl << std::endl;

    // Read Cipher Text from file
    cipher.readFile(textFile);
    cipher.readAndCalculate();
    
    // setkeyword, must be set for cipher
    setKeyword("black");

    changeBlockOrder();

    organizeOrder();

    calculate();
    
    std::cout << "Key: " << keyWord << std::endl;
    std::cout << "PlainText: " << cipherText << std::endl;
    std::cout << "Word: " << getDecipherText() << std::endl;
    //std::cout << "leuword.size()" << keyWord.size() << std::endl;

    // print key order
    //print();

    while(true){

        std::string response = "n";

        std::cout << std::endl << "Does this plaintext look correct? (y/n):    ";
        std::cin >> response;
        std::cout << std::endl << "Ending Anagram Decryption" << std::endl << std::endl;

        if (response == "y"){
            return 1;
        }
        else if(response == "n"){
            return 0;
        }
        else{
            std::cout << std::endl << "**INVALID RESPONSE**" << std::endl;

            if(std::cin.fail()){
                std::cin.clear();
                std::cin.ignore(100 , '\n');
            }
        }
    }
}