from sys import stdin, stdout, maxsize

def get_ternary_string(input_text: str) -> int:
    index = [0] * 3 
    count = maxsize
    left = 0
    
    for right in range(0, len(input_text)):
        
        pos = ord(input_text[right]) - 49
        index[pos] += 1      
        while index[ord(input_text[left]) - 49 ] > 1 : 
            index[ord(input_text[left]) - 49] -= 1
            left += 1 
                
        if index[0] != 0 and index[1] != 0 and index[2] != 0:
            count = min(count,   right - left + 1)
       
        
    return 0 if count == maxsize else count

test_cases = int(stdin.readline().strip())

while test_cases > 0:
    input_text = stdin.readline().strip() 
    print(get_ternary_string(input_text))
    test_cases -= 1
