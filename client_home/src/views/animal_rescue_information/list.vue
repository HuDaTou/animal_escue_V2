<template>
	<div class="diy_list page_animal_rescue_information" id="animal_rescue_information_list">
		<div class="warp">
			<div class="container diy_list_container">
				<div class="diy_list_title">
					<div class="col">
						<span class="title">救助动物信息列表</span>
					</div>
				</div>
				<div class="row diy_list_search">
					<div class="col">
						<!-- 搜索栏 -->
						<div class="view">
							<span class="diy_list_search_title">关键字搜索：</span>
									<b-form-input size="sm" class="mr-sm-2" placeholder="动物名称搜索" v-model="query['animal_name']" />
									<b-form-input size="sm" class="mr-sm-2" placeholder="动物类别搜索" v-model="query['animal_category']" />
													<b-button size="sm" @click="search()" >
								<b-icon icon="search"/>
							</b-button>
						</div>
						<!-- /搜索栏 -->
					</div>
				</div>
				<div class="diy_list_select_box">
					<span class="diy_list_select_title">下拉搜索：</span>
						<div class="diy_list_dropdown_box">
						<div class="col">
							<!-- 筛选 -->
							<div class="view">
																<b-dropdown text="动物类别" variant="outline-dark" left>
									<b-dropdown-item @click="filter_set('全部','animal_category')">全部</b-dropdown-item>
										<b-dropdown-item v-for="(o, i) in list_animal_category" :key="i" @click="filter_set(o['category_of_animal_rescue'],'animal_category')" >
												{{ o['category_of_animal_rescue'] }}
										</b-dropdown-item>
								</b-dropdown>
															</div>
							<!-- /筛选 -->
						</div>
					</div>
					<div class="diy_list_sort_box">
						<div class="col">
							<!-- 排序 -->
							<div class="view">
								<b-dropdown text="排序" variant="outline-dark" left>
										<b-dropdown-item v-for="(o, i) in list_sort" :key="i" @click="set_sort(o)" >
												{{ o.name }}
										</b-dropdown-item>
								</b-dropdown>
							</div>
							<!--/排序 -->
						</div>
					</div>
				</div>

				<div class="row diy_list_box">
					<div class="col">
						<!-- 列表 -->
						<list_animal_rescue_information :list="list" />
						<!-- /列表 -->
					</div>
				</div>
				<div class="row diy_list_page_box">
					<div class="col overflow-auto flex_cc">
						<!-- 分页器 -->
<!--						<diy_pager v-model="query['page']" :size="query['size']" :count="count" v-on:toPage="toPage" v-on:toSize="toSize" ></diy_pager>-->
            <b-pagination
                v-model="query.page"
                :total-rows="count"
                :per-page="query.size"
                @change="goToPage"
            />
						<!-- /分页器 -->
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import list_animal_rescue_information from "@/components/diy/list_animal_rescue_information.vue";
	import diy_pager from "@/components/diy/diy_pager";
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		components: {
			diy_pager,
			list_animal_rescue_information
		},
		data() {
			return {
				url_get_list: "~/api/animal_rescue_information/get_list?like=0",

				// 查询条件
				query: {
					keyword: "",
					page: 1,
					size: 10,
									"animal_name": "", // 动物名称
											"animal_category": "", // 动物类别
												},

				// 排序内容
				list_sort: [{
						name: "创建时间从高到低",
						value: "create_time desc",
					},
					{
						name: "创建时间从低到高",
						value: "create_time asc",
					},
					{
						name: "更新时间从高到低",
						value: "update_time desc",
					},
					{
						name: "更新时间从低到高",
						value: "update_time asc",
					},
							{
						name: "动物名称正序",
						value: "animal_name asc",
					},
					{
						name: "动物名称倒序",
						value: "animal_name desc",
					},
							{
						name: "动物类别正序",
						value: "animal_category asc",
					},
					{
						name: "动物类别倒序",
						value: "animal_category desc",
					},
										],

									// 动物类别列表
				"list_animal_category": [""],
							// 动物性别列表
				"list_animal_sex": ['公','母'],
											// 疫苗接种情况列表
				"list_vaccination": ['是','否'],
				
			}
		},
		methods: {
      get_list_before(param) {
      },
			/**
			 * 筛选选择
			 */
			filter_set(o,key) {
			    if (o == "全部") {
			        this.query[key] = "";
			    } else {
			        this.query[key] = o;
			    }
			    this.search();
			},

			/**
			 * 排序
			 */
			set_sort(o) {
			    this.query.orderby = o.value;
			    this.search();
			},


						/**
			 * 获取动物类别列表
			 */
			async get_list_animal_category() {
				var json = await this.$get("~/api/classification_of_rescue_animals/get_list?");
				if (json.result) {
					this.list_animal_category = json.result.list;
				} else if (json.error) {
					console.log(json.error);
				}
			},
						
			/**
			 * 筛选
			 */
													filter_animal_category(o) {
				if (o == "全部") {
					this.query["animal_category"] = "";
				} else {
					this.query["animal_category"] = o;
				}
				this.search();
			},
													/**
			 * 重置
			 */
			reset() {
								this.query.animal_name = ""
										this.query.animal_category = ""
												this.search();
			},

			// 返回条数
			toSize(i){
				this.query.size = i;
				this.first();
			},

			// 返回页数
			toPage(i){
				this.query.page = i;
				this.first();
			},

      goToPage(v){
        this.query.page = v;
        this.goToNew(v)
      },

		},
		computed: {
		},
		created() {
								/**
			 * 获取动物类别列表
			 */
			this.get_list_animal_category();
														}
	}
</script>

<style>
</style>
