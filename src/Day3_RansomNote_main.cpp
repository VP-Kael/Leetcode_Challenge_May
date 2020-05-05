/*
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */

#include <iostream>
#include <set>

static bool canConstruct(std::string ransomNote, std::string magazine) {
    std::multiset<char> mag(magazine.begin(), magazine.end());
    std::multiset<char> ransom(ransomNote.begin(), ransomNote.end());
    return std::includes(mag.begin(), mag.end(), ransom.begin(), ransom.end());
}

int main() {
    char J[] = "aa";
    char S[] = "aab";
    std::cout << canConstruct(J, S) << std::endl;
    return 0;
}


