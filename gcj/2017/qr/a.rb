# 2017/4/8 Google Code Jam
# Qualification Round A. Oversized Pancake Flipper
# E.Yoshihara

def main
  test_num = gets.chomp.to_i
  test_num.times do |t|
    # input
    s, k = gets.chomp.split(' ')
    k = k.to_i

    ans = calc(s, k)
  
    puts "Case ##{t+1}: #{ans}"
  end
end

@flip_mem = {}
def flip(row)
  ret = @flip_mem[row]
  unless ret
    flip_row = row.split('').map do |r|
      case r
      when '+'
        '-'
      when '-'
        '+'
      end
    end.join
    @flip_mem[row] = flip_row
    ret = @flip_mem[row]
  end
  ret
end


def calc(s, k)
  row = s.dup
  @flip_mem = {}

  i = row.index('-')
  count = 0
  while i && row.size - i >= k
    row[i, k] = flip(row[i, k])
    count += 1
    i = row.index('-')
  end

  return 'IMPOSSIBLE' if row.index('-')
  return count
end


main
