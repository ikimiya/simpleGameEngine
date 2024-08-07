#ifndef CAESARD_H_EXISTS
#define CAESARD_H_EXISTS

#include "Words.h"

#include <string>

class CaesarD
{
        public:
		std::string file;
                CaesarD();
                ~CaesarD();
		void setFile(std::string fileName);
                std::string shift(std::string alphabet);
                int solve(std::string message);
                std::string decode(std::string token, std::string key);
		int fileR();
};

#endif
