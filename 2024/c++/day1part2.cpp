#include <bits/stdc++.h>
#include <cmath>
#include <iostream>
#include <unordered_map>
using namespace std;

vector<string> split(const string &s, char delimiter) {
    vector<string> tokens;
    string token;
    stringstream ss(s); 
    
    while (getline(ss, token, delimiter)) {
        tokens.push_back(token);
    }
    
    return tokens;
}

int main() {
    ifstream file("../Input/day1.1.txt");
    if (!file.is_open()) {
        cerr << "Error opening the file!";
        return 1;
    }
    string line;
    vector<int> array1;
    unordered_map<int, int> map;
    while (getline(file, line)) {
        array1.push_back(stoi(split(line, ' ').at(0)));
        int key = stoi(split(line, ' ').at(3));
        if (map.count(key)) {
            map.at(key) = map.at(key) + 1;
        } else {
            map.insert({key, 1});
        }
    }

    int sum = 0;
    for (int i = 0; i < array1.size(); i++) {
        if (map.count(array1.at(i))) {
            sum += array1.at(i) * map.at(array1.at(i));
        }
    }
    file.close();
    cout << sum << endl;
    return 0;
}