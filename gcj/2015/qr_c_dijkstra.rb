# -*- coding: utf-8 -*-
# GCJ 2014 QR C. Dijkstra


class Test

  @@red_pat = { 2 => "jk|ki|ij", 3 => "kik|jij|kjk|iji|iki|jkj", 5 => "iiiii|jjjjj|kkkkk" }

  @@red_mem = { 2 =>
    {"jk" => "i", "ki" => "j", "ij" => "k"},
    3 =>
    {"kik" => "i", "jij" => "i", "kjk" => "j", "iji" => "j", "iki" => "k", "jkj" => "k"},
    5 =>
    {"iiiii" => "i", "jjjjj" => "j", "kkkkk" => "k"}}

  @@red_it = @@red_pat.keys.sort_by{|val| -val}

  # @stock = []

  def reduce (str)
    if str == "" then
      # puts "DEBUG ::: error!"
      return str
    end

    red_str = str.dup

    index = red_str.length
    i = 0

    # while i < @@red_it.length do
    #   index = @@red_it[i]
    #   if index > red_str.length then
    #     index = red_str.length
    #   end

    #   while !@@red_pat.key?(index) && i < @@red_it.length do
    #     if index > @@red_it[i] then
    #       index = @@red_it[i]
    #       break
    #     else
    #       i = i + 1
    #     end
    #   end
      
    #   if !(i < @@red_it.length) then break end


    @@red_it.each { |index|
      red_str.gsub!(/#{@@red_pat[index]}/, @@red_mem[index])
    }
    #   i = i + 1
    # end

    # puts ("DEBUG:: red_str:#{red_str}, str#{str}")

    if red_str.length == 1 || red_str == str then
      # # memo
      # if red_str != str && str.length < 2000 &&
      #     !(@@red_pat.key?(str.length) && @@red_mem[str.length].key?(str)) then
      #   @stock << str
      # end

      # if @stock != nil then
      #   @stock.each { |bef_str|
      #     bef_len = bef_str.length
      #     if @@red_pat.key?(bef_len) then
      #       if !@@red_mem[bef_len].key?(bef_str) then
      #         @@red_pat[bef_len] = @@red_pat[bef_len] + "|" + bef_str
      #         @@red_mem[bef_len][bef_str] = red_str
      #       end
      #     else
      #       @@red_pat[bef_len] = bef_str
      #       @@red_mem[bef_len] = {bef_str => red_str}
      #     end
      #   }
      #   if @@red_it.length <  @@red_pat.keys.length then
      #     @@red_it = @@red_pat.keys.sort_by{|val| -val}
      #   end
      # end
      return red_str
    else
      # if str.length < 2000 then @stock << str end
      return reduce(red_str)
    end

  end



  def judge (str, ans)
    # puts ("DEBUG:: judge_str:#{str[0..10]}, ans#{ans}")
    if str.length == 1 then
      if str == ans then
        return true
      else
        return false
      end
    else
      # @stock = []
      red_str = reduce(str)
      if red_str.length == 1 && red_str == ans then
        return true
      else
        return false
      end
    end

  end


  def test_i (letters, let_len, p1)

    while p1 <= let_len-2 do
      if judge(letters[0..(p1-1)], "i") then
        break
      end
      p1 = p1 + 1
    end

    return p1

  end

  def test_k_j (letters, let_len, p1, p2)

    while p2 <= let_len-1 do
      if judge(letters[p2..(let_len)], "k") then
        break
      end
      p2 = p2 + 1
    end
    if p2 >= let_len then
      p1 = p1 + 1
      return p1

    end

    #puts "DEBUG::let_len #{letters.length}, p1 #{p1}, p2-1 #{p2-1}"
    if judge(letters[p1..(p2-1)], "j") then
      return 0 # 0 is true flag
    else
      return test_k_j(letters, let_len, p1, p2 + 1)
    end
  end






  ## main

  def main
    test_case = gets.chomp.to_i

    for t_i in 1..test_case

      (length, xtimes) = gets.chomp.split(" ")
      letter = gets.chomp

      # preparing for quiz
      letters = ""
      xtimes.to_i.times do
        letters << letter
      end
      let_len = letters.length

      result = false

      # (L*X)-1 C 2
      # max_comb = ( let_len * let_len - 1) / 2

      p1 = 1
      p2 = 2

      while let_len - p1 >= 2 do
        if letter.length == 1 then break end
        # if !((letter.include?("k") && letter.include?("j")) ||
        #     (letter.include?("i") && letter.include?("j")) ||
        #     (letter.include?("i") && letter.include?("k"))) then
        #   break end
        if let_len < 3 then break end

        # left
        p1 = test_i(letters, let_len, p1)
        if let_len - p1 < 2 then break end

        # right
        p2 = p1 + 1
        p1 = test_k_j(letters, let_len, p1, p2)
        if p1 == 0 then
          result = true
          break
        end

      end


      


      print "Case ##{t_i}: "
      

      if result then
        puts "YES"
      else
        puts "NO"
      end

    end

  end


end



test = Test.new

test.main


