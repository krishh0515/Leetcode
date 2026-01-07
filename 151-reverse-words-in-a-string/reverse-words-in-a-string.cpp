class Solution {
public:
    string reverseWords(string s) {
        vector<string> words;
        int i = 0, n = s.length();

        while (i < n) {
            // skip spaces
            while (i < n && s[i] == ' ')
                i++;

            if (i >= n) break;

            int j = i;
            // read a word
            while (j < n && s[j] != ' ')
                j++;

            words.push_back(s.substr(i, j - i));
            i = j;
        }

        // build result in reverse order
        string result;
        for (int k = words.size() - 1; k >= 0; k--) {
            result += words[k];
            if (k > 0)
                result += " ";
        }

        return result;
    }
};
