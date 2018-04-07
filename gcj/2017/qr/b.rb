# 2017/4/8 Google Code Jam
# Qualification Round B. Tidy Numbers
# E.Yoshihara

def main
  test_num = gets.chomp.to_i
  test_num.times do |t|
    # input
    num = gets.chomp.to_i

    ans = calc(num)
  
    puts "Case ##{t+1}: #{ans}"
  end
end

def calc(n)
  num = n.to_s.split('').map(&:to_i)
  i = num.size - 1
  while i > 0
    if num[i] < num[i - 1]
      num[i - 1] -= 1
      num[i..num.size - 1] = Array.new(num.size - i, 9)
    end
    i -= 1
  end
  num.join.to_i
end


main
