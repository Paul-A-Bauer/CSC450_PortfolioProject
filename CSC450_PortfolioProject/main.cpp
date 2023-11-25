//
//  main.cpp
//  CSC450_PortfolioProject
//
//  Created by Paul Bauer on 11/24/23.
//

#include <iostream>
#include <thread>
#include <mutex>

std::mutex mute;

void count(int start, int end, int increment){
    std::lock_guard<std::mutex>lock(mute); //lock so that it is not interrupted
    
    for(int i = start; i != (end + increment); i += increment){
        std::cout << i << " ";
    }
    std::cout << "\n";
}

int main(int argc, const char * argv[]) {
    
    std::thread t1(count, 0, 20, 1);
    std::thread t2(count, 20, 0, -1);
    
    t1.join();
    t2.join();
    
    return 0;
}
