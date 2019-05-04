def bubble_sort(to_sort: list) -> None:
    is_sorted = False
    last_unsorted = len(to_sort) - 1
    while not is_sorted:
        is_sorted = True
        for index in range(0, last_unsorted):
            if to_sort[index] > to_sort[index + 1]:
                is_sorted = False
                swap(to_sort, index, index + 1)
                print(to_sort)
        last_unsorted -= 1


def swap(swap_in: list, first_index: int, second_index: int):
    swap_in[first_index], swap_in[second_index] = swap_in[second_index], swap_in[first_index]


bubble_sort([22, 1, 4, 3, 11, 6, 7, 9])
