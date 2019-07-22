import pandas as pd

tb_its_link_df_prefix = 'C:/Users/user/Desktop/tb_its_link'
tb_its_link_df = pd.read_csv('%s/tb_its_link.csv' % tb_its_link_df_prefix)
link_id_list = list(tb_its_link_df.drop_duplicates(['link_id'], keep='first').link_id)

start_date = 20190601
fin_date = 20190630
tb_its_traffic_hourly_df_prefix = 'C:/Users/user/Desktop/tb_its_traffic_hourly'

while True:
    tb_its_traffic_hourly_df = pd.read_csv('%s/%s_tb_its_traffic_hourly.csv'
                                           % (tb_its_traffic_hourly_df_prefix, start_date))

    result_df = pd.DataFrame(index=link_id_list)
    for i in range(24):
        series = pd.Series(list(tb_its_traffic_hourly_df[tb_its_traffic_hourly_df.base_hour == i]['average_speed']),
                           index=list(tb_its_traffic_hourly_df[tb_its_traffic_hourly_df.base_hour == i]['link_id']))
        result_df[i] = series

    result_df.to_csv('%s_traffic_hourly_result.csv' % start_date)

    if start_date == fin_date:
        break

    start_date += 1

print('fin...')
