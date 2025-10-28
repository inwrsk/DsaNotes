#convert all the a's to b's in a string
'''
if given string has len 0 then nothing to do much with it so return empty string or itself

else string len is not 0 the seperate first char and remaining part
get the ans for remaining part 
if char contains a or A change it to b

return char+(ans of remaining part)
'''
def replaceatob(s):
    if len(s)==0:
        return ''
    minires=replaceatob(s[1:])
    if s[0]=='a' or s[0]=='A':
        return 'b'+minires
    return s[0]+minires
print(replaceatob('Anwar'))#bnwbr