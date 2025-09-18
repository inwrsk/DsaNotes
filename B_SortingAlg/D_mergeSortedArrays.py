# we take an empty array to store the final sorted array
# we assign two pointers on the each sorted array and start comparing the values
# which ever is smaller we put that in final sorted array and the pointer of that array moves forward
# Its like we pick the smaller in every moment out of the both arrays
def merge(arr1, arr2):
    arr = []
    i = j = 0
    while i<len(arr1) and j<len(arr2):
        if arr1[i]<arr2[j]:
            arr.append(arr1[i])
            i+=1
        else:
            arr.append(arr2[j])
            j+=1
    while i<len(arr1):
        arr.append(arr1[i])
        i+=1
    while j<len(arr2):
        arr.append(arr2[j])
        j+=1
    return arr
arr1 = [1, 3, 5, 5, 7]
arr2 = [2, 2, 4, 6]
print("after merging : ", arr1, arr2)
print(merge(arr1, arr2))
