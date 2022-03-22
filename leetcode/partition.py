class Solution:
    # https://support.leetcode.com/hc/en-us/articles/360011834174-I-encountered-Wrong-Answer-Runtime-Error-for-a-specific-test-case-When-I-test-my-code-using-this-test-case-it-produced-the-correct-output-Why-
    def __init__(self):
        self.output = []

    def is_palindrome(self, s: str):

        left = 0
        right = len(s) -1

        while left < right:
            if s[left] != s[right]:
                return False
            left += 1
            right -= 1

        return True

    def get_partition(self, s : str, res : List[str]):

        if not s:
            self.output.append(res)

        for i in range(0, len(s)):
            prefix = s[0:i + 1]
            suffix = s[i + 1:]

            if self.is_palindrome(prefix):
                # make a deep copy
                temp_res = res[:]
                temp_res.append(prefix)

                self.get_partition(suffix, temp_res)


    def partition(self, s: str) -> List[List[str]]:
        self.get_partition(s, [])
        return self.output
