import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from '@/router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
// import * as ElIcon from '@element-plus/icons-vue'
// import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
// import 'font-awesome/css/font-awesome.min.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'


const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
  }
app.use(router)
app.use(ElementPlus)

// app.component("font-awesome-icon", FontAwesomeIcon)
// Object.keys(ElIcon).forEach((key) => {
//     app.component(key, ElIcon[key])
// })


app.mount('#app')
