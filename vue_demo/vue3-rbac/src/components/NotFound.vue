
import router from '@/router';

<template>
    <div class="notfound">
        <div class="wrapper">
            <div class="big">页面不见了</div>
            <div>首页瞧瞧，点击<router-link to="/login">这里</router-link>进入首页.</div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {};
    },
};
</script>

<style>
/* .notfound {
    height: 100%;
    background-image: url('../assets/22.png'), url('../assets/22.png');
    background-position: right top, center center;
    background-repeat: no-repeat,repeat;
    background-size: cover, auto;
}
.notfound .wrapper {
    position: absolute;
    top: 60%;
   right: 2%;
   color: #fff;
   width: 635px;
   font-size:19px;
   line-height: 79px;
   
} */
</style>