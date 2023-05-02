<template>
  <div class="data-chart flex">
    <div class="flex-item data-chart-item">
      <div class="title">数据统计一</div>
    <div class="flex">
        <div class="icon">
            <el-icon><Search /></el-icon>
        </div>
        <div class="flex-item value">56893</div>
        <div class="tongbi">15.3%</div>
    </div>
    </div>
    <div class="flex-item data-chart-item">
        <div class="title">数据统计二</div>
    <div class="flex">
        <div class="icon">
            <el-icon><Refresh /></el-icon>
        </div>
        <div class="flex-item value">3147</div>
        <div class="tongbi">10.3%</div>
    </div>
    </div>
    <div class="flex-item data-chart-item">
        <div class="title">数据统计三</div>
    <div class="flex">
        <div class="icon">
            <el-icon><MessageBox /></el-icon>
        </div>
        <div class="flex-item value">96358</div>
        <div class="tongbi">2.3%</div>
    </div>
    </div>
    <div class="flex-item data-chart-item">
        <div class="title">数据统计四</div>
    <div class="flex">
        <div class="icon">
            <el-icon><Bell /></el-icon>
        </div>
        <div class="flex-item value">8563</div>
        <div class="tongbi">6.3%</div>
    </div>
    </div>
  </div>

  <div class="chart-demo"></div>
</template>

<style scoped>
    .data-chart{
        margin: 10px;
    }
    .data-chart .data-chart-item{
        background: #fff;
        border-radius: 5px;
        height: 80px;
        padding: 0 10px;
    }
    .data-chart .data-chart-item .title{
        font-size: 20px;
        line-height: 45px;
    }
    .data-chart .data-chart-item .icon{
        font-size: 16px;
        line-height: 40px;
        margin-right: 10px;
        width: 40px;
    }
    .data-chart .data-chart-item .value{
        font-size: 18px;
        line-height: 36px;
    }
    .data-chart .data-chart-item .tongbi{
        font-size: 16px;
        line-height: 36px;
    }
</style>
