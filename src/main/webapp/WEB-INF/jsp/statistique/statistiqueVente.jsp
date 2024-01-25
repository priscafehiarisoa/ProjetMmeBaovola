<%--
  Created by IntelliJ IDEA.
  User: priscafehiarisoadama
  Date: 25/01/2024
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../template/header.jsp" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.1/flowbite.min.css" rel="stylesheet">
<script>
  // ApexCharts options and config
  window.addEventListener("load", function() {
    const getChartOptions = () => {
      return {
        series: [35.1, 23.5, 2.4, 5.4],
        colors: ["#1C64F2", "#16BDCA", "#FDBA8C", "#E74694"],
        chart: {
          height: 320,
          width: "100%",
          type: "donut",
        },
        stroke: {
          colors: ["transparent"],
          lineCap: "",
        },
        plotOptions: {
          pie: {
            donut: {
              labels: {
                show: true,
                name: {
                  show: true,
                  fontFamily: "Inter, sans-serif",
                  offsetY: 20,
                },
                total: {
                  showAlways: true,
                  show: true,
                  label: "Unique visitors",
                  fontFamily: "Inter, sans-serif",
                  formatter: function (w) {
                    const sum = w.globals.seriesTotals.reduce((a, b) => {
                      return a + b
                    }, 0)
                    return `${sum}k`
                  },
                },
                value: {
                  show: true,
                  fontFamily: "Inter, sans-serif",
                  offsetY: -20,
                  formatter: function (value) {
                    return value + "k"
                  },
                },
              },
              size: "80%",
            },
          },
        },
        grid: {
          padding: {
            top: -2,
          },
        },
        labels: ["Direct", "Sponsor", "Affiliate", "Email marketing"],
        dataLabels: {
          enabled: false,
        },
        legend: {
          position: "bottom",
          fontFamily: "Inter, sans-serif",
        },
        yaxis: {
          labels: {
            formatter: function (value) {
              return value + "k"
            },
          },
        },
        xaxis: {
          labels: {
            formatter: function (value) {
              return value  + "k"
            },
          },
          axisTicks: {
            show: false,
          },
          axisBorder: {
            show: false,
          },
        },
      }
    }

    if (document.getElementById("donut-chart") && typeof ApexCharts !== 'undefined') {
      const chart = new ApexCharts(document.getElementById("donut-chart"), getChartOptions());
      chart.render();

      // Get all the checkboxes by their class name
      const checkboxes = document.querySelectorAll('#devices input[type="checkbox"]');

      // Function to handle the checkbox change event
      function handleCheckboxChange(event, chart) {
        const checkbox = event.target;
        if (checkbox.checked) {
          switch(checkbox.value) {
            case 'desktop':
              chart.updateSeries([15.1, 22.5, 4.4, 8.4]);
              break;
            case 'tablet':
              chart.updateSeries([25.1, 26.5, 1.4, 3.4]);
              break;
            case 'mobile':
              chart.updateSeries([45.1, 27.5, 8.4, 2.4]);
              break;
            default:
              chart.updateSeries([55.1, 28.5, 1.4, 5.4]);
          }

        } else {
          chart.updateSeries([35.1, 23.5, 2.4, 5.4]);
        }
      }

      // Attach the event listener to each checkbox
      checkboxes.forEach((checkbox) => {
        checkbox.addEventListener('change', (event) => handleCheckboxChange(event, chart));
      });
    }
  });
</script>

<div class="py-6" id="donut-chart" style="min-height: 287.7px;">
<%--  <div id="apexchartsuv1cpyzj" class="apexcharts-canvas apexchartsuv1cpyzj apexcharts-theme-light" style="width: 260px; height: 287.7px;"><svg id="SvgjsSvg151750" width="260" height="287.70000000000005" xmlns="http://www.w3.org/2000/svg" version="1.1" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:svgjs="http://svgjs.dev" class="apexcharts-svg" xmlns:data="ApexChartsNS" transform="translate(0, 0)" style="background: none;">--%>
    <foreignObject x="0" y="0" width="260" height="287.70000000000005">
      <div class="apexcharts-legend apexcharts-align-center apx-legend-position-bottom" xmlns="http://www.w3.org/1999/xhtml" style="inset: auto 0px 1px; position: absolute; max-height: 160px;"><div class="apexcharts-legend-series" rel="1" seriesname="Direct" data:collapsed="false" style="margin: 2px 5px;"><span class="apexcharts-legend-marker" rel="1" data:collapsed="false" style="background: rgb(28, 100, 242) !important; color: rgb(28, 100, 242); height: 12px; width: 12px; left: 0px; top: 0px; border-width: 0px; border-color: rgb(255, 255, 255); border-radius: 12px;"></span><span class="apexcharts-legend-text" rel="1" i="0" data:default-text="Direct" data:collapsed="false" style="color: rgb(55, 61, 63); font-size: 12px; font-weight: 400; font-family: Inter, sans-serif;">Direct</span></div><div class="apexcharts-legend-series" rel="2" seriesname="Sponsor" data:collapsed="false" style="margin: 2px 5px;"><span class="apexcharts-legend-marker" rel="2" data:collapsed="false" style="background: rgb(22, 189, 202) !important; color: rgb(22, 189, 202); height: 12px; width: 12px; left: 0px; top: 0px; border-width: 0px; border-color: rgb(255, 255, 255); border-radius: 12px;"></span><span class="apexcharts-legend-text" rel="2" i="1" data:default-text="Sponsor" data:collapsed="false" style="color: rgb(55, 61, 63); font-size: 12px; font-weight: 400; font-family: Inter, sans-serif;">Sponsor</span></div><div class="apexcharts-legend-series" rel="3" seriesname="Affiliate" data:collapsed="false" style="margin: 2px 5px;"><span class="apexcharts-legend-marker" rel="3" data:collapsed="false" style="background: rgb(253, 186, 140) !important; color: rgb(253, 186, 140); height: 12px; width: 12px; left: 0px; top: 0px; border-width: 0px; border-color: rgb(255, 255, 255); border-radius: 12px;"></span><span class="apexcharts-legend-text" rel="3" i="2" data:default-text="Affiliate" data:collapsed="false" style="color: rgb(55, 61, 63); font-size: 12px; font-weight: 400; font-family: Inter, sans-serif;">Affiliate</span></div><div class="apexcharts-legend-series" rel="4" seriesname="Emailxmarketing" data:collapsed="false" style="margin: 2px 5px;"><span class="apexcharts-legend-marker" rel="4" data:collapsed="false" style="background: rgb(231, 70, 148) !important; color: rgb(231, 70, 148); height: 12px; width: 12px; left: 0px; top: 0px; border-width: 0px; border-color: rgb(255, 255, 255); border-radius: 12px;"></span><span class="apexcharts-legend-text" rel="4" i="3" data:default-text="Email%20marketing" data:collapsed="false" style="color: rgb(55, 61, 63); font-size: 12px; font-weight: 400; font-family: Inter, sans-serif;">Email marketing</span></div></div><style type="text/css">
  .apexcharts-legend {
    display: flex;
    overflow: auto;
    padding: 0 10px;
  }
  .apexcharts-legend.apx-legend-position-bottom, .apexcharts-legend.apx-legend-position-top {
    flex-wrap: wrap
  }
  .apexcharts-legend.apx-legend-position-right, .apexcharts-legend.apx-legend-position-left {
    flex-direction: column;
    bottom: 0;
  }
  .apexcharts-legend.apx-legend-position-bottom.apexcharts-align-left, .apexcharts-legend.apx-legend-position-top.apexcharts-align-left, .apexcharts-legend.apx-legend-position-right, .apexcharts-legend.apx-legend-position-left {
    justify-content: flex-start;
  }
  .apexcharts-legend.apx-legend-position-bottom.apexcharts-align-center, .apexcharts-legend.apx-legend-position-top.apexcharts-align-center {
    justify-content: center;
  }
  .apexcharts-legend.apx-legend-position-bottom.apexcharts-align-right, .apexcharts-legend.apx-legend-position-top.apexcharts-align-right {
    justify-content: flex-end;
  }
  .apexcharts-legend-series {
    cursor: pointer;
    line-height: normal;
  }
  .apexcharts-legend.apx-legend-position-bottom .apexcharts-legend-series, .apexcharts-legend.apx-legend-position-top .apexcharts-legend-series{
    display: flex;
    align-items: center;
  }
  .apexcharts-legend-text {
    position: relative;
    font-size: 14px;
  }
  .apexcharts-legend-text *, .apexcharts-legend-marker * {
    pointer-events: none;
  }
  .apexcharts-legend-marker {
    position: relative;
    display: inline-block;
    cursor: pointer;
    margin-right: 3px;
    border-style: solid;
  }

  .apexcharts-legend.apexcharts-align-right .apexcharts-legend-series, .apexcharts-legend.apexcharts-align-left .apexcharts-legend-series{
    display: inline-block;
  }
  .apexcharts-legend-series.apexcharts-no-click {
    cursor: auto;
  }
  .apexcharts-legend .apexcharts-hidden-zero-series, .apexcharts-legend .apexcharts-hidden-null-series {
    display: none !important;
  }
  .apexcharts-inactive-legend {
    opacity: 0.45;
  }</style></foreignObject><g id="SvgjsG151752" class="apexcharts-inner apexcharts-graphical" transform="translate(12, -2)"><defs id="SvgjsDefs151751"><clipPath id="gridRectMaskuv1cpyzj"><rect id="SvgjsRect151753" width="244" height="249" x="-4" y="-6" rx="0" ry="0" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0" fill="#fff"></rect></clipPath><clipPath id="forecastMaskuv1cpyzj"></clipPath><clipPath id="nonForecastMaskuv1cpyzj"></clipPath><clipPath id="gridRectMarkerMaskuv1cpyzj"><rect id="SvgjsRect151754" width="242" height="241" x="-2" y="-2" rx="0" ry="0" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0" fill="#fff"></rect></clipPath></defs><g id="SvgjsG151755" class="apexcharts-pie"><g id="SvgjsG151756" transform="translate(0, 0) scale(1)"><circle id="SvgjsCircle151757" r="87.6878048780488" cx="119" cy="118.5" fill="transparent"></circle><g id="SvgjsG151758" class="apexcharts-slices"><g id="SvgjsG151759" class="apexcharts-series apexcharts-pie-series" seriesName="Direct" rel="1" data:realIndex="0"><path id="SvgjsPath151760" d="M 119 8.89024390243901 A 109.60975609756099 109.60975609756099 0 1 1 99.39926507790757 226.34298689428383 L 103.31941206232605 204.77438951542706 A 87.6878048780488 87.6878048780488 0 1 0 119 30.812195121951206 L 119 8.89024390243901 z " fill="rgba(28,100,242,1)" fill-opacity="1" stroke-opacity="1" stroke-linecap="" stroke-width="2" stroke-dasharray="0" class="apexcharts-pie-area apexcharts-donut-slice-0" index="0" j="0" data:angle="190.3012048192771" data:startAngle="0" data:strokeWidth="2" data:value="35.1" data:pathOrig="M 119 8.89024390243901 A 109.60975609756099 109.60975609756099 0 1 1 99.39926507790757 226.34298689428383 L 103.31941206232605 204.77438951542706 A 87.6878048780488 87.6878048780488 0 1 0 119 30.812195121951206 L 119 8.89024390243901 z " stroke="transparent"></path></g><g id="SvgjsG151761" class="apexcharts-series apexcharts-pie-series" seriesName="Sponsor" rel="2" data:realIndex="1"><path id="SvgjsPath151762" d="M 99.39926507790757 226.34298689428383 A 109.60975609756099 109.60975609756099 0 0 1 45.24660671873417 37.41525660603136 L 59.997285374987335 53.63220528482509 A 87.6878048780488 87.6878048780488 0 0 0 103.31941206232605 204.77438951542706 L 99.39926507790757 226.34298689428383 z " fill="rgba(22,189,202,1)" fill-opacity="1" stroke-opacity="1" stroke-linecap="" stroke-width="2" stroke-dasharray="0" class="apexcharts-pie-area apexcharts-donut-slice-1" index="0" j="1" data:angle="127.40963855421685" data:startAngle="190.3012048192771" data:strokeWidth="2" data:value="23.5" data:pathOrig="M 99.39926507790757 226.34298689428383 A 109.60975609756099 109.60975609756099 0 0 1 45.24660671873417 37.41525660603136 L 59.997285374987335 53.63220528482509 A 87.6878048780488 87.6878048780488 0 0 0 103.31941206232605 204.77438951542706 L 99.39926507790757 226.34298689428383 z " stroke="transparent"></path></g><g id="SvgjsG151763" class="apexcharts-series apexcharts-pie-series" seriesName="Affiliate" rel="3" data:realIndex="2"><path id="SvgjsPath151764" d="M 45.24660671873417 37.41525660603136 A 109.60975609756099 109.60975609756099 0 0 1 65.39710340580893 22.89127598132444 L 76.11768272464715 42.01302078505955 A 87.6878048780488 87.6878048780488 0 0 0 59.997285374987335 53.63220528482509 L 45.24660671873417 37.41525660603136 z " fill="rgba(253,186,140,1)" fill-opacity="1" stroke-opacity="1" stroke-linecap="" stroke-width="2" stroke-dasharray="0" class="apexcharts-pie-area apexcharts-donut-slice-2" index="0" j="2" data:angle="13.01204819277109" data:startAngle="317.71084337349396" data:strokeWidth="2" data:value="2.4" data:pathOrig="M 45.24660671873417 37.41525660603136 A 109.60975609756099 109.60975609756099 0 0 1 65.39710340580893 22.89127598132444 L 76.11768272464715 42.01302078505955 A 87.6878048780488 87.6878048780488 0 0 0 59.997285374987335 53.63220528482509 L 45.24660671873417 37.41525660603136 z " stroke="transparent"></path></g><g id="SvgjsG151765" class="apexcharts-series apexcharts-pie-series" seriesName="Emailxmarketing" rel="4" data:realIndex="3"><path id="SvgjsPath151766" d="M 65.39710340580893 22.89127598132444 A 109.60975609756099 109.60975609756099 0 0 1 118.980869488735 8.890245571891057 L 118.984695590988 30.81219645751284 A 87.6878048780488 87.6878048780488 0 0 0 76.11768272464715 42.01302078505955 L 65.39710340580893 22.89127598132444 z " fill="rgba(231,70,148,1)" fill-opacity="1" stroke-opacity="1" stroke-linecap="" stroke-width="2" stroke-dasharray="0" class="apexcharts-pie-area apexcharts-donut-slice-3" index="0" j="3" data:angle="29.277108433734952" data:startAngle="330.72289156626505" data:strokeWidth="2" data:value="5.4" data:pathOrig="M 65.39710340580893 22.89127598132444 A 109.60975609756099 109.60975609756099 0 0 1 118.980869488735 8.890245571891057 L 118.984695590988 30.81219645751284 A 87.6878048780488 87.6878048780488 0 0 0 76.11768272464715 42.01302078505955 L 65.39710340580893 22.89127598132444 z " stroke="transparent"></path></g></g></g><g id="SvgjsG151767" class="apexcharts-datalabels-group" transform="translate(0, 0) scale(1)"><text id="SvgjsText151768" font-family="Inter, sans-serif" x="119" y="138.5" text-anchor="middle" dominant-baseline="auto" font-size="16px" font-weight="400" fill="#373d3f" class="apexcharts-text apexcharts-datalabel-label" style="font-family: Inter, sans-serif;">Unique visitors</text><text id="SvgjsText151769" font-family="Inter, sans-serif" x="119" y="114.5" text-anchor="middle" dominant-baseline="auto" font-size="20px" font-weight="400" fill="#373d3f" class="apexcharts-text apexcharts-datalabel-value" style="font-family: Inter, sans-serif;">66.4k</text></g></g><line id="SvgjsLine151770" x1="0" y1="0" x2="238" y2="0" stroke="#b6b6b6" stroke-dasharray="0" stroke-width="1" stroke-linecap="butt" class="apexcharts-ycrosshairs"></line><line id="SvgjsLine151771" x1="0" y1="0" x2="238" y2="0" stroke-dasharray="0" stroke-width="0" stroke-linecap="butt" class="apexcharts-ycrosshairs-hidden"></line></g></svg><div class="apexcharts-tooltip apexcharts-theme-dark"><div class="apexcharts-tooltip-series-group" style="order: 1;"><span class="apexcharts-tooltip-marker" style="background-color: rgb(28, 100, 242);"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-y-label"></span><span class="apexcharts-tooltip-text-y-value"></span></div><div class="apexcharts-tooltip-goals-group"><span class="apexcharts-tooltip-text-goals-label"></span><span class="apexcharts-tooltip-text-goals-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div><div class="apexcharts-tooltip-series-group" style="order: 2;"><span class="apexcharts-tooltip-marker" style="background-color: rgb(22, 189, 202);"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-y-label"></span><span class="apexcharts-tooltip-text-y-value"></span></div><div class="apexcharts-tooltip-goals-group"><span class="apexcharts-tooltip-text-goals-label"></span><span class="apexcharts-tooltip-text-goals-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div><div class="apexcharts-tooltip-series-group" style="order: 3;"><span class="apexcharts-tooltip-marker" style="background-color: rgb(253, 186, 140);"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-y-label"></span><span class="apexcharts-tooltip-text-y-value"></span></div><div class="apexcharts-tooltip-goals-group"><span class="apexcharts-tooltip-text-goals-label"></span><span class="apexcharts-tooltip-text-goals-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div><div class="apexcharts-tooltip-series-group" style="order: 4;"><span class="apexcharts-tooltip-marker" style="background-color: rgb(231, 70, 148);"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-y-label"></span><span class="apexcharts-tooltip-text-y-value"></span></div><div class="apexcharts-tooltip-goals-group"><span class="apexcharts-tooltip-text-goals-label"></span><span class="apexcharts-tooltip-text-goals-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div></div></div></div>


<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.1/flowbite.min.js"></script>