#include <bits/stdc++.h>
#include <iostream>
#include <cmath>
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
    vector<int> array2;
    while (getline(file, line)) {
        array1.push_back(stoi(split(line, ' ').at(0)));
        array2.push_back(stoi(split(line, ' ').at(3)));
        cout << line << endl;
    }
    stable_sort(array1.begin(), array1.end());
    stable_sort(array2.begin(), array2.end());

    int sum = 0;
    for (int i = 0; i < array1.size(); i++) {
        sum += abs(array1.at(i) - array2.at(i));
    }
    file.close();
    cout << sum << endl;
    return 0;
}