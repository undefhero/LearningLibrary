package validanagram

// func isAnagram(s string, t string) bool {
// 	if len(s) != len(t) {
// 		return false
// 	}

// 	letters := make(map[rune]int, 26)

// 	for _, char := range s {
// 		letters[char]++
// 	}

// 	for _, char := range t {
// 		letters[char]--

// 		if letters[char] < 0 {
// 			return false
// 		}
// 	}

// 	return true
// }

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	freq := make([]int, 26)

	for i := range len(s) {
		freq[s[i]-'a']++
		freq[t[i]-'a']--
	}

	for i := range len(freq) {
		if freq[i] < 0 {
			return false
		}
	}

	return true
}
