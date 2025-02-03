#include "utils.h"
#include <cmath>

bool isSafe(const std::vector<int>& report) {
    if (report.size() < 2) return true;

    int left = report[0];
    int right = report[1];
    bool isIncreasing = right > left;

    for (size_t i = 0; i < report.size() - 1; i++) {
        left = report[i];
        right = report[i + 1];
        bool difference = std::abs(right - left) >= 1 && std::abs(right - left) <= 3;

        if ((isIncreasing && left > right) || (!isIncreasing && right > left) || !difference) {
            return false;
        }
    }
    return true;
}
