def make_change(coins: list, money: int) -> int:
    return make_change_with_index(coins, money, 0, {})


def make_change_with_index(coins: list, money: int, index: int, cache: dict) -> int:
    if money == 0:
        return 1
    if index >= len(coins):
        return 0

    key = str(money) + '-' + str(index)
    if key in cache:
        return cache[key]

    amount_with_coin = 0
    ways = 0

    while amount_with_coin <= money:
        remaining = money - amount_with_coin
        ways += make_change_with_index(coins, remaining, index + 1, cache)
        amount_with_coin += coins[index]

    cache[key] = ways
    return ways


print(make_change([100, 50, 20, 10, 5], 100))
