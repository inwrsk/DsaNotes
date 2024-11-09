# counts zeroes in a number
def countZeros(number):
    if number<10:
        if number==0:
            return 1
        else:
            return 0
    if number%10==0:
        return 1+countZeros(number//10)
    else:return countZeros(number//10)
print(countZeros(5032300))#3