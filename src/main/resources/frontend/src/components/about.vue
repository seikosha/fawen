<template>
  <el-container>
    <left_card id="left_card"></left_card>

    <el-main>
      <el-col id="maintext">
      <h2> 网站简介 </h2>
      <h4> 建站初衷 </h4>
      <p style="text-align: left; padding-left:30px; padding-right:10px">
      &nbsp&nbsp&nbsp&nbsp站长本人在初入职场时，也拍过职场精英照，就是那种你能在别的律所网站上看到的那种律师职业照。
      虽然站长本人还觉得挺人模狗样的，但站长的妈妈觉得那就是一个典型的江湖骗子形象，并认为经过这样包装的律师一定会坑自己一笔大钱的。<br><br>
      &nbsp&nbsp&nbsp&nbsp虽然站长有一点无奈，但不得不说这确实反映了一个事实。<strong>我国法律职业群体所提供的法律服务，与一般大众的需要存在巨大差异。</strong>
      <br><br>
      &nbsp&nbsp&nbsp&nbsp从<strong>需求</strong>这一侧来讲，我们所处的社会中，最庞大的法律需求并不是请律师代为诉讼控告辩护代理，而是简单的法律咨询。
      是一种意图用于指导自己后续行为或者自助救济的法律咨询。能够满足这样需求的人群，并不需要有太强的专业性，
      也不需要专业而神秘的包装，需要的是简单、亲和而清晰地给出意见。然而很遗憾，人们似乎并不愿意为满足这种需求而付费。
      这其实很容易理解，因为一项专业一旦揭下自己神秘的面纱变得亲和，在更好用的同时就会显得更掉价。
      <br><br>
      &nbsp&nbsp&nbsp&nbsp从<strong>供应</strong>这一侧来讲，律师会出于经济的原因天然地追求"二八原则"：砍掉上述琐碎而无利可图的业务，
      去追逐名利双收的大案大项目。这也是律师都要进行精英包装的原因。这个社会上存在的最庞大的法律需求却只有少数公益律师或依相关法规要履行相应公益义务的律师来满足。
      在站长看来是远远不够的。
      <br><br>
      &nbsp&nbsp&nbsp&nbsp本站建立的初衷就是为了解决这个问题，解决它的契机在于改善供应这一侧。拓宽法律服务供应的源头，应当吸引更多的法律人来进行免费的回复。
      <br><br>
      &nbsp&nbsp&nbsp&nbsp为什么会觉得免费做法律咨询会有人做？因为社会上还有很多未得到充分利用的法律人。比如法学院的学生。
      我国有大量的法学院学生缺乏实践经验。我们的法学教育喜欢以极端案例来明理，学生却缺少真实案例的历练；在校生实习渠道有限，况且很多短期实习并不能充分执法、司法实践。
      如果我的网站能帮助法学院学生充实自己的实践经验，进而美化自己的简历，同时提供学习法律中最迷人的一点：帮助他人的成就感。我相信会有人愿意做的。
      <br><br>
      &nbsp&nbsp&nbsp&nbsp当然，我相信如果缺乏案源或者低年级律师愿意的话，他们也能在我的网站上有所收获。这能帮助他们建立个人品牌，建立与客户的初步联系和信任。
        同样，本站也欢迎各种社会法律人士对有需求的大众提供援手。无论目的是为了牟利还是为了公益。</p>
      <br><br>
      <hr>

      <h4> 灵感来源 </h4>
      <p style="text-align: left; padding-left:30px; padding-right:10px">
      &nbsp&nbsp&nbsp&nbsp自从学写程序以来，我就没有哪天是不上<a href="https://stackoverflow.com/">stackoverflow</a>这样的问答网站的。
      在这类网站上，提问人可以将某一答案设为已解决问题，这是对回答者的一大褒奖，结合对回答者熟悉领域以及答题质量的数据分析，就更可以用来丰富回答者的履历。
      国内并不缺法律问答网站，但是这一类网站要不过于执着于盈利，要不就不能给回答者以足够的激励或是不能让提问者感到放心，结合stackoverflow等优秀问答社区的做法，
      有助于把评判权利更多地交给提问者，而不是由回答者通过制造劣质答案来刷流量。也许通过这种方式，能做出更合用的法律问答网站。
      </p>
      <br><br>
      <hr>
      <h4> 联系方式 </h4>
      <p style="text-align: left; padding-left:30px; padding-right:10px">
      &nbsp&nbsp&nbsp&nbsp站长邮箱：zi.xiong@foxmail.com
      <br><br>
      &nbsp&nbsp&nbsp&nbsp欢迎给我来信，对网站提任何意见！
      </p>
      </el-col>
    </el-main>

    <right_card id="right_card"></right_card>
  </el-container>
</template>

<script>
    import left_card from "./left_card";
    import right_card from "./right_card";

    export default {
        name: "about",
        components:{
          left_card,
          right_card
        }
    }
</script>

<style scoped>
  @media screen and (max-width: 768px) {
    #maintext{
      position:relative;
    }
    #left_card,#right_card{
      display:none;
    }
  }
</style>
