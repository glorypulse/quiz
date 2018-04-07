# coding: utf-8
# 2017/4/8 Google Code Jam
# Qualification Round C. Bathroom Stalls
# E.Yoshihara

include Math

def main
  test_num = gets.chomp.to_i
  test_num.times do |t|
    # input
    n, k = gets.chomp.split(' ').map(&:to_i)

    ans = calc(k, n)
  
    puts "Case ##{t+1}: #{ans}"
  end
end

# あふれ確認
def fix(base, k)
  right = base
  while 2 ** right > k
    right = base - 1
  end
  right
end

def calc(k, n)
  base = 0
  if k == 1
    base = n
  else
    k_base = (log(k) / log(2)).to_i
    k_base = fix(k_base, k)
    base = (n - k) / (2 ** k_base) + 1
  end
  
  min = 0; max = n
  if base.odd?
    min = (base - 1) / 2
    max = (base - 1) / 2
  else
    min = base / 2 - 1
    max = base / 2
  end
  "#{max} #{min}"
end

main
